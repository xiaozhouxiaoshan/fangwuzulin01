$ErrorActionPreference = "Stop"

$workDir = "D:\BaiduNetdiskDownload\T020源码\T020源码\_doc_work"
$src = Join-Path $workDir "thesis.docx"
$dst = Join-Path $workDir "thesis_updated.docx"

Copy-Item -Force $src $dst

function Normalize-ParaText([string]$t) {
  if ($null -eq $t) { return "" }
  # Word paragraphs typically end with CR (13) and sometimes BEL (7)
  $t = $t -replace "[\r\a]+$",""
  return $t.Trim()
}

$word = New-Object -ComObject Word.Application
$word.Visible = $false
$word.DisplayAlerts = 0

$doc = $null
try {
  $doc = $word.Documents.Open($dst)

  function Find-ParaIndexExact([string]$exact) {
    for ($i = 1; $i -le $doc.Paragraphs.Count; $i++) {
      $t = Normalize-ParaText $doc.Paragraphs.Item($i).Range.Text
      if ($t -eq $exact) { return $i }
    }
    return $null
  }

  function Find-ParaIndexContains([string]$contains) {
    for ($i = 1; $i -le $doc.Paragraphs.Count; $i++) {
      $t = Normalize-ParaText $doc.Paragraphs.Item($i).Range.Text
      if ($t -like "*$contains*") { return $i }
    }
    return $null
  }

  function Set-ParaText([int]$index, [string]$text) {
    $r = $doc.Paragraphs.Item($index).Range
    if ($null -eq $text) { $text = "" }
    $text = $text.TrimEnd("`r")
    $r.Text = $text + "`r"
  }

  function Set-RangeText([int]$start, [int]$end, [string]$text) {
    $r = $doc.Range($start, $end)
    if ($null -eq $text) { $text = "" }
    $text = $text.TrimEnd("`r")
    $r.Text = $text + "`r"
  }

  function Delete-ParaByExact([string]$exact) {
    $idx = Find-ParaIndexExact $exact
    if ($idx) {
      $doc.Paragraphs.Item($idx).Range.Delete()
      return $true
    }
    return $false
  }

  # --- 技术介绍段落：按标题定位并替换其后正文 ---
  $idx = Find-ParaIndexExact "Spring Boot 框架"
  if ($idx) {
    Set-ParaText ($idx + 1) "Spring Boot 在 Spring 体系基础上提供自动配置、起步依赖（starter）与内嵌容器等机制，能够以“约定优于配置”的方式减少繁琐的工程化配置，从而提升 Web 应用的开发与部署效率。[1][2]"
    Set-ParaText ($idx + 2) "本系统后端基于 Spring Boot 构建 RESTful 接口，通过 Controller–Service–DAO（Mapper）分层组织业务逻辑与数据访问，使职责清晰、便于测试与后期扩展。[1][2]"
  }

  $idx = Find-ParaIndexExact "MyBatis / MyBatis-Plus 持久层技术"
  if ($idx) {
    Set-ParaText ($idx + 1) "MyBatis 通过映射文件或注解将 SQL 与 Java 对象进行绑定，兼顾 SQL 可控性与持久层开发效率；在此基础上，MyBatis-Plus 提供通用 CRUD 能力以减少重复代码。[3]"
    Set-ParaText ($idx + 2) "系统持久层采用 MyBatis-Plus 与 MySQL 交互，围绕房屋信息、预约看房、合同信息、报修与维修处理等核心表进行增删改查，实现业务数据的统一存取。[3][7]"
  }

  $idx = Find-ParaIndexExact "Vue.js 框架"
  if ($idx) {
    Set-ParaText ($idx + 1) "Vue.js 是渐进式前端框架，强调组件化与响应式数据驱动视图更新，适用于构建单页面应用并提升交互体验。[4]"
    Set-ParaText ($idx + 2) "系统前端采用 Vue.js 组织页面组件与路由，并结合组件库完成后台管理端界面搭建，实现房源管理、预约审核等功能页面的快速开发与复用。[4]"
  }

  $idx = Find-ParaIndexExact "Element UI 组件库"
  if ($idx) {
    Set-ParaText ($idx + 1) "Element UI 是面向桌面端的 Vue 组件库，提供表格、表单、对话框等常用组件，可用于快速构建管理后台界面。"
    Set-ParaText ($idx + 2) "本系统后台管理端通过 Element UI 统一交互与视觉规范，降低页面搭建成本，提高表单与列表类页面的一致性。"
  }

  $idx = Find-ParaIndexExact "ECharts 数据可视化技术"
  if ($idx) {
    Set-ParaText ($idx + 1) "ECharts 提供折线图、柱状图、饼图等图表能力，适合将业务统计结果可视化展示；系统在租赁与报修等统计页面中使用 ECharts 生成图表，以提升数据呈现的直观性。[5]"
  }

  $idx = Find-ParaIndexExact "MySQL 数据库"
  if ($idx) {
    Set-ParaText ($idx + 1) "MySQL 是常用关系型数据库管理系统，支持事务与索引等机制，适用于中小型业务系统的数据持久化。[6][7]"
    Set-ParaText ($idx + 2) "本系统使用 MySQL 存储房屋信息、房主/用户信息、预约看房、合同、报修与评价等数据，并通过表结构与字段约束保证数据一致性与可维护性。[6][7]"
  }

  $idx = Find-ParaIndexExact "系统总体架构设计"
  if ($idx) {
    Set-ParaText ($idx + 1) "系统采用前后端分离架构：前端通过 HTTP/JSON 调用后端 REST 接口完成数据交互，后端负责业务处理与数据持久化，从而实现界面与业务逻辑解耦。[8]"
    Set-ParaText ($idx + 2) "后端按表示层（Controller）、业务层（Service）与数据访问层（DAO/Mapper）进行分层设计，并以统一返回结构封装结果，便于模块化开发与维护。[8]"
  }

  # --- 需求分析：管理员/租客段落按范围整体替换（避免逐段增删） ---
  $idxAdmin = Find-ParaIndexExact "3.2.1 管理员功能需求"
  $idxTenant = Find-ParaIndexExact "3.2.2 租客功能需求"
  $idxNonFunc = Find-ParaIndexExact "3.3 非功能性需求分析"

  if ($idxAdmin -and $idxTenant) {
    $start = $doc.Paragraphs.Item($idxAdmin + 1).Range.Start
    $end = $doc.Paragraphs.Item($idxTenant).Range.Start
    $adminBody = @(
      "管理员是系统的核心管理角色，主要负责基础数据维护与业务流程监管，其功能需求包括：",
      "（1）用户与房主管理：维护用户（租客）与房主的基础信息，支持查询、修改、新增与删除。",
      "（2）房屋类型管理：维护房屋类型字典数据，为房源发布与检索提供分类依据。",
      "（3）房屋信息管理：对房源信息进行增删改查，并支持查看房源评论及回复。",
      "（4）预约看房管理：查看用户提交的预约看房信息，进行审核与回复。",
      "（5）合同信息管理：维护合同信息，记录租期、金额与支付状态，并支持审核回复。",
      "（6）报修与维修处理管理：管理报修信息与维修处理记录，跟踪维修进度并进行审核回复。",
      "（7）房屋评价管理：查看用户评价信息，对评价进行审核并可填写审核回复。",
      "（8）我要当房主管理：对“我要当房主”申请信息进行审核与回复，并支持查看相关评论与回复。",
      "（9）公告与系统配置：发布与维护公告信息，并维护系统基础配置数据。",
      "（10）留言板管理：对留言板信息进行查询与管理，保障信息交流的规范性。"
    ) -join "`r"
    Set-RangeText $start $end $adminBody
  }

  if ($idxTenant -and $idxNonFunc) {
    $start = $doc.Paragraphs.Item($idxTenant + 1).Range.Start
    $end = $doc.Paragraphs.Item($idxNonFunc).Range.Start
    $tenantBody = @(
      "租客是系统的主要使用角色之一，其功能需求包括：",
      "（1）用户注册与登录：完成账号注册、登录与个人信息维护。",
      "（2）房屋信息浏览与检索：浏览房源列表与详情，并按关键字、房屋类型等条件进行查询。",
      "（3）收藏管理：对感兴趣的房源进行收藏，便于后续快速查看。",
      "（4）预约看房：在线提交预约看房申请，并查看审核状态与回复。",
      "（5）合同信息查询：查看与自身相关的合同信息、租期与支付状态等。",
      "（6）报修与维修进度查询：提交报修申请并跟踪维修处理进度与反馈。",
      "（7）评价与评论：对租赁体验进行评价，并对房源或相关信息进行评论。",
      "（8）我要当房主：提交“我要当房主”申请信息，等待管理员审核并查看审核结果。",
      "（9）留言反馈与公告查看：在留言板进行反馈交流，并查看系统公告信息。"
    ) -join "`r"
    Set-RangeText $start $end $tenantBody
  }

  # --- 插入 3.2.3 房主功能需求（在 3.3 之前） ---
  $idxNonFunc = Find-ParaIndexExact "3.3 非功能性需求分析"
  if ($idxNonFunc) {
    $insertPos = $doc.Paragraphs.Item($idxNonFunc).Range.Start
    $sel = $word.Selection
    $sel.SetRange($insertPos, $insertPos)

    $sel.Style = $doc.Styles.Item("Heading 3")
    $sel.TypeText("3.2.3 房主功能需求")
    $sel.TypeParagraph()

    # Some docs use "Normal (Web)", fall back to "Normal" if missing
    try { $sel.Style = $doc.Styles.Item("Normal (Web)") } catch { $sel.Style = $doc.Styles.Item("Normal") }
    $sel.TypeText("房主作为房源提供方，主要围绕房源发布、预约审核与租后服务开展业务，其功能需求包括：")
    $sel.TypeParagraph()

    $items = @(
      "（1）房屋信息管理：对本人房源信息进行新增、修改、上下架等管理，并维护房屋图片与详细描述。",
      "（2）预约看房管理：查看用户预约看房信息，对预约进行审核并填写审核回复。",
      "（3）合同信息管理：维护与租客相关的合同信息，记录租期、金额与支付状态，并查看审核回复。",
      "（4）报修管理：查看租客提交的报修信息，对报修进行审核回复并跟踪处理情况。",
      "（5）维修处理管理：对维修过程填写维修进度与反馈信息，记录维修更新日期等。",
      "（6）评价管理：查看房屋评价信息并可进行审核回复，便于形成服务闭环。"
    )
    foreach ($it in $items) {
      $sel.TypeText($it)
      $sel.TypeParagraph()
    }
    $sel.TypeParagraph()
  }

  # --- 数据表设计：替换模板占位与示例 ---
  $idxPlaceholder = Find-ParaIndexContains "（此处 表 4.1 ～ 表 4.13"
  if ($idxPlaceholder) {
    $tablesText = @(
      "系统数据库共设计 18 张业务表，覆盖系统配置、用户与角色、房源、预约、合同、报修与维修、评价与评论、收藏与公告等功能。核心表说明如下：",
      "（1）users：后台管理员账号信息。",
      "（2）token：登录令牌、角色信息与过期时间。",
      "（3）yonghu：租客用户信息（含联系方式、职业等）。",
      "（4）fangzhu：房主信息（含联系方式、身份证号等）。",
      "（5）fangwuleixing：房屋类型字典数据。",
      "（6）fangwuxinxi：房屋信息（房源）与发布信息。",
      "（7）yuyuekanfang：预约看房记录与审核信息。",
      "（8）hetongxinxi：合同信息、租期金额与支付状态。",
      "（9）fangwubaoxiu：房屋报修申请与审核回复。",
      "（10）weixiuchuli：维修处理记录（进度、反馈与更新日期）。",
      "（11）fangwupingjia：房屋评价信息与审核回复。",
      "（12）woyaodangfangzhu：我要当房主申请信息与审核回复。",
      "（13）discussfangwuxinxi：房屋信息评论与回复。",
      "（14）discusswoyaodangfangzhu：我要当房主评论与回复。",
      "（15）storeup：收藏记录。",
      "（16）messages：留言板信息。",
      "（17）news：公告信息。",
      "（18）config：系统配置（如轮播/参数）。"
    ) -join "`r"
    Set-ParaText $idxPlaceholder $tablesText
  }
  # 删除示例段落（可能存在于同一段或后一段）
  while (Delete-ParaByExact "示例：") { }
  $idxExample = Find-ParaIndexContains "表 4.1 报修表"
  if ($idxExample) { $doc.Paragraphs.Item($idxExample).Range.Delete() }

  # --- 关键技术：Token / 上传 / 推荐 ---
  $idx = Find-ParaIndexExact "Token 拦截器设计"
  if ($idx) {
    Set-ParaText ($idx + 1) "系统采用基于 Token 的认证机制：用户登录成功后由后端生成随机 Token，并写入 token 表（包含用户标识、角色、关联表与过期时间）；前端在后续请求的 Header 中携带 Token，后端拦截器在每次请求中校验 Token 有效性并将用户信息写入 Session，从而实现接口访问控制与多角色隔离。[1][8]"
  }

  $idx = Find-ParaIndexExact "文件上传设计"
  if ($idx) {
    Set-ParaText ($idx + 1) "系统提供统一的文件上传接口用于房源图片等资源的存储：后端接收 MultipartFile，将文件保存至 static/upload 目录并返回文件名；业务表（如房屋信息、报修等）通过保存图片路径实现前端展示与管理。[1][2]"
  }

  $idx = Find-ParaIndexContains "（8）简易智慧推荐模块"
  if ($idx) {
    Set-ParaText $idx "（8）数据可视化与推荐扩展模块`n系统在后台统计页面以图表方式呈现租赁与报修等业务数据；同时记录用户收藏等行为数据（如收藏表 storeup），为后续引入个性化推荐算法提供数据基础。[5][9]"
  }

  $idx = Find-ParaIndexExact "智慧推荐模型设计"
  if ($idx) {
    Set-ParaText ($idx + 1) "系统目前实现的“智慧推荐”以规则化展示为主：在房源列表中支持按关键字与房屋类型等条件检索，同时记录用户收藏（storeup）等行为数据，为后续引入推荐算法（如基于相似度的协同过滤）提供数据基础。[9]"
  }

  $idx = Find-ParaIndexExact "智慧推荐功能实现"
  if ($idx) {
    Set-ParaText ($idx + 1) "在系统前端实现房源列表与详情页展示，用户可对房源进行收藏，后台将收藏记录写入 storeup 表。当前版本的推荐相关功能主要体现为“可沉淀的行为数据 + 可扩展的推荐入口”，后续可基于收藏、浏览等行为构建个性化推荐模块。[9]"
  }

  $idx = Find-ParaIndexContains "智慧推荐功能目前较为简单"
  if ($idx) {
    Set-ParaText $idx "尽管系统在功能和运行方面能够满足基本需求，但仍存在一定不足之处。例如，推荐功能目前以规则展示为主，尚未引入更复杂的个性化推荐算法；系统在高并发场景下的性能仍需进一步测试和提升；系统界面在交互体验方面还有改进空间。"
  }

  # --- 参考文献：替换示例为真实书籍条目，并与正文 [n] 对齐 ---
  $idxRef = Find-ParaIndexExact "参考文献"
  $idxThanks = Find-ParaIndexExact "致谢"
  if ($idxRef -and $idxThanks) {
    $start = $doc.Paragraphs.Item($idxRef + 1).Range.Start
    $end = $doc.Paragraphs.Item($idxThanks).Range.Start
    $refs = @(
      "[1] Walls C. Spring Boot in Action[M]. Shelter Island, NY: Manning Publications, 2016.",
      "[2] Walls C. Spring in Action (Sixth Edition)[M]. Shelter Island, NY: Manning Publications, 2022.",
      "[3] Suereth J. Java Persistence with MyBatis 3[M]. Birmingham: Packt Publishing, 2013.",
      "[4] 霍春阳. Vue.js设计与实现[M]. 北京: 人民邮电出版社, 2022.",
      "[5] 范路桥, 张良均, 郑述招, 肖秀娟, 李明. Web数据可视化（ECharts版）[M]. 北京: 人民邮电出版社, 2021.",
      "[6] Forta B. MySQL必知必会（第2版）[M]. 北京: 人民邮电出版社, 2024.",
      "[7] Silberschatz A, Korth H F, Sudarshan S. 数据库系统概念（第6版）[M]. 北京: 机械工业出版社, 2012.",
      "[8] Sommerville I. Software Engineering (10th Edition)[M]. Boston: Pearson, 2015.",
      "[9] 项亮. 推荐系统实践[M]. 北京: 人民邮电出版社, 2012.",
      "[10] Horstmann C S. Core Java Volume I—Fundamentals (11th Edition)[M]. Upper Saddle River, NJ: Prentice Hall, 2018."
    ) -join "`r"
    Set-RangeText $start $end $refs
  }

  $doc.Save()
} finally {
  if ($doc) { $doc.Close() | Out-Null }
  if ($word) { $word.Quit() | Out-Null }
  [System.GC]::Collect()
  [System.GC]::WaitForPendingFinalizers()
}

Write-Host "Updated thesis saved to: $dst"
