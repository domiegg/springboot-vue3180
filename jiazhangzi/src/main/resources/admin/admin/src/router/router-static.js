import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import banzhurentongzhi from '@/views/modules/banzhurentongzhi/list'
    import chengji from '@/views/modules/chengji/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import guanliyuantongzhi from '@/views/modules/guanliyuantongzhi/list'
    import huida from '@/views/modules/huida/list'
    import jiaofei from '@/views/modules/jiaofei/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import jiazhangxuesheng from '@/views/modules/jiazhangxuesheng/list'
    import kaoshi from '@/views/modules/kaoshi/list'
    import kebiao from '@/views/modules/kebiao/list'
    import yijianjianyi from '@/views/modules/yijianjianyi/list'
    import zuoye from '@/views/modules/zuoye/list'
    import dictionaryBanji from '@/views/modules/dictionaryBanji/list'
    import dictionaryBanzhurentongzhi from '@/views/modules/dictionaryBanzhurentongzhi/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryGuanliyuantongzhi from '@/views/modules/dictionaryGuanliyuantongzhi/list'
    import dictionaryJiaofei from '@/views/modules/dictionaryJiaofei/list'
    import dictionaryJiaofeiShifou from '@/views/modules/dictionaryJiaofeiShifou/list'
    import dictionaryKaoshi from '@/views/modules/dictionaryKaoshi/list'
    import dictionaryKemu from '@/views/modules/dictionaryKemu/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryXingqi from '@/views/modules/dictionaryXingqi/list'
    import dictionaryYijianjianyi from '@/views/modules/dictionaryYijianjianyi/list'
    import dictionaryZuoye from '@/views/modules/dictionaryZuoye/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBanji',
        name: '班级',
        component: dictionaryBanji
    }
    ,{
        path: '/dictionaryBanzhurentongzhi',
        name: '班主任通知类型',
        component: dictionaryBanzhurentongzhi
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryGuanliyuantongzhi',
        name: '管理员通知类型',
        component: dictionaryGuanliyuantongzhi
    }
    ,{
        path: '/dictionaryJiaofei',
        name: '缴费类型',
        component: dictionaryJiaofei
    }
    ,{
        path: '/dictionaryJiaofeiShifou',
        name: '是否缴费',
        component: dictionaryJiaofeiShifou
    }
    ,{
        path: '/dictionaryKaoshi',
        name: '学期',
        component: dictionaryKaoshi
    }
    ,{
        path: '/dictionaryKemu',
        name: '科目',
        component: dictionaryKemu
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryXingqi',
        name: '星期',
        component: dictionaryXingqi
    }
    ,{
        path: '/dictionaryYijianjianyi',
        name: '意见建议类型',
        component: dictionaryYijianjianyi
    }
    ,{
        path: '/dictionaryZuoye',
        name: '作业类型',
        component: dictionaryZuoye
    }


    ,{
        path: '/banzhurentongzhi',
        name: '班主任通知',
        component: banzhurentongzhi
      }
    ,{
        path: '/chengji',
        name: '成绩',
        component: chengji
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/guanliyuantongzhi',
        name: '管理员通知',
        component: guanliyuantongzhi
      }
    ,{
        path: '/huida',
        name: '回答',
        component: huida
      }
    ,{
        path: '/jiaofei',
        name: '缴费',
        component: jiaofei
      }
    ,{
        path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }
    ,{
        path: '/jiazhangxuesheng',
        name: '家长学生',
        component: jiazhangxuesheng
      }
    ,{
        path: '/kaoshi',
        name: '考试',
        component: kaoshi
      }
    ,{
        path: '/kebiao',
        name: '课表',
        component: kebiao
      }
    ,{
        path: '/yijianjianyi',
        name: '意见建议',
        component: yijianjianyi
      }
    ,{
        path: '/zuoye',
        name: '作业',
        component: zuoye
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
