DATA = {
    "5_2_1": [
        {
            "type": "text",
            "value": "从实现机制看，管理员模块并不是单纯的页面集合。系统先在登录页根据角色配置确定认证数据表，再将用户名、密码和角色信息提交给后端接口。认证成功后，前端保存 Token、角色名与会话表名，后台页面据此加载管理员可见菜单，并在后续请求中维持登录状态。"
        },
        {
            "type": "label",
            "value": "关键代码：管理员登录与令牌保存"
        },
        {
            "type": "code",
            "value": """let menus = this.menus;
for (let i = 0; i < menus.length; i++) {
  if (menus[i].roleName == this.rulesForm.role) {
    this.tableName = menus[i].tableName;
  }
}
this.$http({
  url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
  method: "post"
}).then(({ data }) => {
  if (data && data.code === 0) {
    this.$storage.set("Token", data.token);
    this.$storage.set("role", this.rulesForm.role);
    this.$storage.set("sessionTable", this.tableName);
    this.$router.replace({ path: "/index/" });
  }
});"""
        },
        {
            "type": "code",
            "value": """@PostMapping(value = "/login")
public R login(String username, String password, String captcha, HttpServletRequest request) {
    UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("username", username));
    if(user==null || !user.getPassword().equals(password)) {
        return R.error("账号或密码不正确");
    }
    String token = tokenService.generateToken(user.getId(),username, "users", user.getRole());
    return R.ok().put("token", token);
}"""
        },
        {
            "type": "text",
            "value": "管理员进入后台后，可见菜单与可执行按钮由角色菜单配置统一控制。房屋信息管理、预约看房管理、房屋报修管理等模块都通过菜单树与管理员角色绑定，因此页面显示范围与业务权限保持一致。"
        },
        {
            "type": "label",
            "value": "关键代码：管理员菜单配置"
        },
        {
            "type": "code",
            "value": """{
  "backMenu":[
    {"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"房屋信息","tableName":"fangwuxinxi"}],"menu":"房屋信息管理"},
    {"child":[{"buttons":["查看","修改","删除","审核","合同"],"menu":"预约看房","tableName":"yuyuekanfang"}],"menu":"预约看房管理"},
    {"child":[{"buttons":["查看","修改","删除","审核","处理"],"menu":"房屋报修","tableName":"fangwubaoxiu"}],"menu":"房屋报修管理"}
  ],
  "roleName":"管理员",
  "tableName":"users"
}"""
        },
        {
            "type": "text",
            "value": "房屋信息管理和预约看房管理共用统一的数据访问接口。管理员访问房屋信息分页接口时不会附加房主筛选条件，因此能够查看全部房源记录；预约列表页则在表格中提供审核与合同按钮，使管理员能够对预约申请继续执行审核和合同生成。"
        },
        {
            "type": "label",
            "value": "关键代码：房屋信息分页接口"
        },
        {
            "type": "code",
            "value": """@RequestMapping("/page")
public R page(@RequestParam Map<String, Object> params,FangwuxinxiEntity fangwuxinxi, HttpServletRequest request){
    String tableName = request.getSession().getAttribute("tableName").toString();
    if(tableName.equals("fangzhu")) {
        fangwuxinxi.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
    }
    EntityWrapper<FangwuxinxiEntity> ew = new EntityWrapper<FangwuxinxiEntity>();
    PageUtils page = fangwuxinxiService.queryPage(params,
        MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangwuxinxi), params), params));
    return R.ok().put("data", page);
}"""
        }
    ],
    "5_2_2": [
        {
            "type": "text",
            "value": "房主模块围绕房源发布、预约处理和租后服务展开。系统并没有为房主单独重写一套业务控制器，而是在统一接口中根据当前会话角色附加筛选条件。这样，房主进入后台后只会看到自己发布的房源、对应的预约记录以及报修记录。"
        },
        {
            "type": "label",
            "value": "关键代码：房主登录认证"
        },
        {
            "type": "code",
            "value": """@RequestMapping(value = "/login")
public R login(String username, String password, String captcha, HttpServletRequest request) {
    FangzhuEntity user = fangzhuService.selectOne(
        new EntityWrapper<FangzhuEntity>().eq("fangzhuzhanghao", username));
    if(user==null || !user.getMima().equals(password)) {
        return R.error("账号或密码不正确");
    }
    String token = tokenService.generateToken(user.getId(), username,"fangzhu",  "房主" );
    return R.ok().put("token", token);
}"""
        },
        {
            "type": "text",
            "value": "房主进入业务模块后，系统把 Session 中保存的 tableName 和 username 作为过滤依据写入房主账号字段。这样，房主在查看房屋信息、预约看房和房屋报修时，读取范围始终限制在本人名下数据。这一处理方式直接支撑了房主参与租赁全流程管理的业务逻辑。"
        },
        {
            "type": "label",
            "value": "关键代码：房主维度的数据隔离"
        },
        {
            "type": "code",
            "value": """if(tableName.equals("fangzhu")) {
    fangwuxinxi.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
}

if(tableName.equals("fangzhu")) {
    yuyuekanfang.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
}

if(tableName.equals("fangzhu")) {
    fangwubaoxiu.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
}"""
        },
        {
            "type": "text",
            "value": "由此，房主模块不仅包含房源录入页面，还通过统一认证、角色识别与条件查询把房源发布、预约审核和维修跟踪组织为连续业务链。"
        }
    ],
    "5_3": [
        {
            "type": "text",
            "value": "用户模块承担房源浏览、预约看房、合同查询、报修申请和收藏管理等功能。为了避免各页面分别处理身份状态，系统在请求层统一附加 Token，并在身份失效时自动跳回登录页。这样，用户无论在前台浏览房源还是在后台查看预约记录，都运行在同一套认证机制下。"
        },
        {
            "type": "label",
            "value": "关键代码：用户请求拦截与登录状态维持"
        },
        {
            "type": "code",
            "value": """http.interceptors.request.use(config => {
    config.headers["Token"] = storage.get("Token")
    return config
}, error => {
    return Promise.reject(error)
})

http.interceptors.response.use(response => {
    if (response.data && response.data.code === 401) {
        router.push({ name: "login" })
    }
    return response
}, error => {
    return Promise.reject(error)
})"""
        },
        {
            "type": "text",
            "value": "在房屋信息页面，用户可以直接从房源列表发起预约申请。前端通过“预约”按钮把当前房源数据带入预约表单，后端在预约分页接口中按当前用户名过滤记录，因此用户后台只展示本人提交的预约信息。这样，房源浏览与预约申请被整合在同一业务流程中。"
        },
        {
            "type": "label",
            "value": "关键代码：用户预约看房"
        },
        {
            "type": "code",
            "value": """<el-button
  v-if="isAuth('fangwuxinxi','预约')"
  type="success"
  size="mini"
  @click="yuyuekanfangCrossAddOrUpdateHandler(scope.row,'cross')"
>预约</el-button>"""
        },
        {
            "type": "code",
            "value": """if(tableName.equals("yonghu")) {
    yuyuekanfang.setYonghuming((String)request.getSession().getAttribute("username"));
}"""
        },
        {
            "type": "text",
            "value": "租住阶段若出现设施故障，用户可以提交报修申请并上传现场图片。系统提供统一文件上传接口，将附件保存到后端静态资源目录，再把返回的文件名写入业务记录。这一实现使报修信息同时具备文本描述与图像材料。"
        },
        {
            "type": "label",
            "value": "关键代码：报修附件上传"
        },
        {
            "type": "code",
            "value": """@RequestMapping("/upload")
public R upload(@RequestParam("file") MultipartFile file,String type) throws Exception {
    if (file.isEmpty()) {
        throw new EIException("上传文件不能为空");
    }
    String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
    File path = new File(ResourceUtils.getURL("classpath:static").getPath());
    File upload = new File(path.getAbsolutePath(),"/upload/");
    if(!upload.exists()) {
        upload.mkdirs();
    }
    String fileName = new Date().getTime()+"."+fileExt;
    File dest = new File(upload.getAbsolutePath()+"/"+fileName);
    file.transferTo(dest);
    return R.ok().put("file", fileName);
}"""
        },
        {
            "type": "text",
            "value": "以上实现说明，用户模块并不是孤立的前台展示页面，而是以认证拦截、预约流转和文件上传为支撑，构成了从房源浏览到租后服务的完整线上使用链路。"
        }
    ]
}
