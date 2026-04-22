<template>
  <div class="assistant-page" :class="{ compact: compact }">
    <div v-if="showHeader" class="assistant-header">
      <div>
        <h2>智能助手</h2>
        <p>{{ headerText }}</p>
      </div>
      <el-tag type="primary" effect="plain">{{ roleLabel }}</el-tag>
    </div>

    <div v-else class="assistant-toolbar">
      <div class="assistant-toolbar-title">
        <span>智能助手</span>
        <el-tag size="mini" type="primary" effect="plain">{{ roleLabel }}</el-tag>
      </div>
      <el-button type="text" @click="openStandalonePage">进入独立页面</el-button>
    </div>

    <div class="quick-actions">
      <el-button
        v-for="item in quickActions"
        :key="item"
        size="mini"
        @click="useQuickAction(item)"
      >
        {{ item }}
      </el-button>
    </div>

    <div ref="chatPanel" class="chat-panel" v-loading="loading">
      <div v-if="!messages.length && !loading" class="empty-tip">
        先问我一个和租房、预约、合同、报修有关的问题。
      </div>

      <div
        v-for="(message, index) in messages"
        :key="index"
        class="message-row"
        :class="message.type"
      >
        <div class="bubble">
          <div class="message-title" v-if="message.title">{{ message.title }}</div>
          <div class="message-text">{{ message.text }}</div>
          <div v-if="message.cards && message.cards.length" class="card-list">
            <div v-for="(card, cardIndex) in message.cards" :key="cardIndex" class="reply-card">
              <div class="reply-card-title">{{ card.title }}</div>
              <div class="reply-card-subtitle">{{ card.subtitle }}</div>
              <div class="reply-card-tag" v-if="card.tag">{{ card.tag }}</div>
              <div class="reply-card-action" v-if="resolveCardPath(card)">
                <el-button size="mini" type="primary" plain @click="navigateTo(resolveCardPath(card))">
                  去查看
                </el-button>
              </div>
            </div>
          </div>
          <div class="message-time" v-if="message.time">{{ message.time }}</div>
        </div>
      </div>
    </div>

    <div class="input-panel">
      <el-input
        v-model="inputText"
        type="textarea"
        :rows="compact ? 2 : 3"
        resize="none"
        placeholder="例如：推荐预算5000以内的房源、看看我的待办、统计待审核预约和合同"
        @keyup.native.enter.exact.prevent="sendMessage"
      />
      <div class="input-actions">
        <el-button @click="resetConversation">重新开始</el-button>
        <el-button type="primary" @click="sendMessage">发送</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    showHeader: {
      type: Boolean,
      default: true
    },
    compact: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      loading: false,
      inputText: "",
      messages: []
    };
  },
  computed: {
    roleLabel() {
      return this.$storage.get("role") || "未登录";
    },
    headerText() {
      if (this.roleLabel === "用户") {
        return "帮你推荐合适房源，并汇总预约、合同和报修情况。";
      }
      if (this.roleLabel === "房主") {
        return "帮你查看房源、待审核预约、合同跟进和报修处理。";
      }
      return "帮你查看系统概览、待审核业务和报修统计。";
    },
    quickActions() {
      if (this.roleLabel === "用户") {
        return [
          "推荐预算5000以内的房源",
          "帮我看看我的预约情况",
          "帮我看看我的合同和报修"
        ];
      }
      if (this.roleLabel === "房主") {
        return [
          "看看我的待办",
          "汇总我的预约审核",
          "汇总我的报修情况"
        ];
      }
      return [
        "查看系统概览",
        "统计待审核预约和合同",
        "汇总报修情况"
      ];
    },
    historyKey() {
      const role = this.$storage.get("role") || "guest";
      const name = this.$storage.get("adminName") || "anonymous";
      return `assistant_history_${role}_${name}`;
    }
  },
  mounted() {
    this.restoreConversation();
    if (!this.messages.length) {
      this.fetchReply("帮助");
    } else {
      this.scrollToBottom();
    }
  },
  methods: {
    restoreConversation() {
      const history = this.$storage.getObj(this.historyKey);
      if (Array.isArray(history)) {
        this.messages = history;
      }
    },
    persistConversation() {
      this.$storage.set(this.historyKey, this.messages.slice(-20));
    },
    useQuickAction(text) {
      this.inputText = text;
      this.sendMessage();
    },
    resetConversation() {
      this.messages = [];
      this.persistConversation();
      this.fetchReply("帮助");
    },
    sendMessage() {
      const text = (this.inputText || "").trim();
      if (!text) {
        this.$message.warning("请输入问题后再发送");
        return;
      }
      this.messages.push({
        type: "user",
        text: text
      });
      this.persistConversation();
      this.inputText = "";
      this.fetchReply(text);
    },
    fetchReply(text) {
      this.loading = true;
      this.$http({
        url: "assistant/chat",
        method: "post",
        data: {
          message: text
        }
      }).then(({ data }) => {
        if (data && data.code === 0) {
          const result = data.data || {};
          this.messages.push({
            type: "assistant",
            title: result.title || "智能助手",
            text: result.reply || "暂无回复",
            cards: result.cards || [],
            time: result.time || ""
          });
          this.persistConversation();
        } else {
          this.$message.error((data && data.msg) || "助手服务异常");
        }
      }).catch(() => {
        this.$message.error("助手服务异常");
      }).finally(() => {
        this.loading = false;
        this.scrollToBottom();
      });
    },
    scrollToBottom() {
      this.$nextTick(() => {
        const panel = this.$refs.chatPanel;
        if (panel) {
          panel.scrollTop = panel.scrollHeight;
        }
      });
    },
    navigateTo(path) {
      if (!path) {
        return;
      }
      this.$router.push(path);
      this.$emit("navigate", path);
    },
    resolveCardPath(card) {
      if (!card) {
        return "";
      }
      if (card.path) {
        return card.path;
      }
      const text = `${card.title || ""} ${card.subtitle || ""} ${card.tag || ""}`;
      if (text.indexOf("预约") !== -1) {
        return "/yuyuekanfang";
      }
      if (text.indexOf("合同") !== -1 || text.indexOf("支付") !== -1) {
        return "/hetongxinxi";
      }
      if (text.indexOf("维修") !== -1) {
        return "/weixiuchuli";
      }
      if (text.indexOf("报修") !== -1) {
        return "/fangwubaoxiu";
      }
      if (text.indexOf("租客总数") !== -1) {
        return "/yonghu";
      }
      if (text.indexOf("房东总数") !== -1) {
        return "/fangzhu";
      }
      if (text.indexOf("房源") !== -1 || text.indexOf("元/月") !== -1 || text.indexOf("可租") !== -1) {
        return "/fangwuxinxi";
      }
      return "";
    },
    openStandalonePage() {
      if (this.$route.path !== "/assistant") {
        this.$router.push("/assistant");
      }
      this.$emit("navigate", "/assistant");
    }
  }
};
</script>

<style lang="scss" scoped>
.assistant-page {
  min-height: 680px;
  display: flex;
  flex-direction: column;
  gap: 16px;

  &.compact {
    min-height: 0;

    .chat-panel {
      min-height: 320px;
      max-height: calc(100vh - 260px);
    }
  }
}

.assistant-header {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  padding: 20px 22px;
  border-radius: 16px;
  background: linear-gradient(135deg, #eef5ff, #f7fbff);
  border: 1px solid rgba(22, 119, 255, 0.12);

  h2 {
    margin: 0 0 6px;
    font-size: 22px;
    color: #1f2937;
  }

  p {
    margin: 0;
    color: #5b6575;
    font-size: 14px;
  }
}

.assistant-toolbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 12px;
}

.assistant-toolbar-title {
  display: flex;
  align-items: center;
  gap: 10px;
  font-size: 16px;
  font-weight: 700;
  color: #1f2937;
}

.quick-actions {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
}

.chat-panel {
  flex: 1;
  min-height: 420px;
  max-height: 560px;
  overflow-y: auto;
  padding: 20px;
  background: #f8fafc;
  border-radius: 16px;
  border: 1px solid #e5e7eb;
}

.empty-tip {
  color: #64748b;
  font-size: 14px;
  text-align: center;
  padding: 40px 20px;
}

.message-row {
  display: flex;
  margin-bottom: 14px;

  &.user {
    justify-content: flex-end;
  }

  &.assistant {
    justify-content: flex-start;
  }
}

.bubble {
  max-width: 82%;
  padding: 14px 16px;
  border-radius: 16px;
  box-shadow: 0 1px 3px rgba(15, 23, 42, 0.06);
}

.user .bubble {
  background: #1677ff;
  color: #fff;
  border-top-right-radius: 6px;
}

.assistant .bubble {
  background: #fff;
  color: #1f2937;
  border-top-left-radius: 6px;
}

.message-title {
  margin-bottom: 8px;
  font-size: 15px;
  font-weight: 700;
}

.message-text {
  white-space: pre-wrap;
  line-height: 1.7;
  font-size: 14px;
}

.message-time {
  margin-top: 10px;
  font-size: 12px;
  color: #94a3b8;
}

.card-list {
  margin-top: 12px;
  display: grid;
  gap: 10px;
}

.reply-card {
  padding: 12px 14px;
  border-radius: 12px;
  background: #f8fbff;
  border: 1px solid rgba(22, 119, 255, 0.12);
}

.reply-card-title {
  font-size: 14px;
  font-weight: 700;
  color: #1f2937;
}

.reply-card-subtitle {
  margin-top: 6px;
  font-size: 13px;
  color: #5b6575;
}

.reply-card-tag {
  margin-top: 8px;
  font-size: 12px;
  color: #1677ff;
}

.reply-card-action {
  margin-top: 10px;
}

.input-panel {
  padding: 18px;
  border-radius: 16px;
  background: #fff;
  border: 1px solid #e5e7eb;
}

.input-actions {
  margin-top: 12px;
  display: flex;
  justify-content: flex-end;
  gap: 10px;
}

@media (max-width: 768px) {
  .assistant-header {
    flex-direction: column;
    gap: 12px;
  }

  .assistant-toolbar {
    flex-direction: column;
    align-items: flex-start;
  }

  .bubble {
    max-width: 100%;
  }
}
</style>
