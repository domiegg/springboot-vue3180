const base = {
    get() {
        return {
            url : "http://localhost:8080/jiazhangzi/",
            name: "jiazhangzi",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/jiazhangzi/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智慧校园之家长子系统"
        } 
    }
}
export default base
