const base = {
    get() {
                return {
            url : "http://localhost:8080/zhihuifangwuzulin/",
            name: "zhihuifangwuzulin",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhihuifangwuzulin/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "房屋租赁系统"
        } 
    }
}
export default base
