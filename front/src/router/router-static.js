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
import assistant from '@/views/modules/assistant/list'
    import houseType from '@/views/modules/houseType/list'
    import houseListingComment from '@/views/modules/houseListingComment/list'
    import announcement from '@/views/modules/announcement/list'
    import repairHandling from '@/views/modules/repairHandling/list'
    import favorite from '@/views/modules/favorite/list'
    import houseReview from '@/views/modules/houseReview/list'
    import houseListing from '@/views/modules/houseListing/list'
    import viewingAppointment from '@/views/modules/viewingAppointment/list'
    import landlordApplication from '@/views/modules/landlordApplication/list'
    import landlord from '@/views/modules/landlord/list'
    import tenant from '@/views/modules/tenant/list'
    import landlordApplicationComment from '@/views/modules/landlordApplicationComment/list'
    import houseRepair from '@/views/modules/houseRepair/list'
    import rentalContract from '@/views/modules/rentalContract/list'
    import messageBoard from '@/views/modules/messageBoard/list'
    import config from '@/views/modules/config/list'


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
    }, {
      path: '/assistant',
      name: 'assistant',
      component: assistant,
      meta: {icon:'', title:'assistant'}
    }
          ,{
	path: '/houseType',
        name: '房屋类型',
        component: houseType
      }
          ,{
	path: '/houseListingComment',
        name: '房屋信息评论',
        component: houseListingComment
      }
          ,{
	path: '/announcement',
        name: '公告信息',
        component: announcement
      }
          ,{
	path: '/repairHandling',
        name: '维修处理',
        component: repairHandling
      }
          ,{
	path: '/favorite',
        name: '我的收藏管理',
        component: favorite
      }
          ,{
	path: '/houseReview',
        name: '房屋评价',
        component: houseReview
      }
          ,{
	path: '/houseListing',
        name: '房屋信息',
        component: houseListing
      }
          ,{
	path: '/viewingAppointment',
        name: '预约看房',
        component: viewingAppointment
      }
          ,{
	path: '/landlordApplication',
        name: '我要当房主',
        component: landlordApplication
      }
          ,{
	path: '/landlord',
        name: '房主',
        component: landlord
      }
          ,{
	path: '/tenant',
        name: '用户',
        component: tenant
      }
          ,{
	path: '/landlordApplicationComment',
        name: '我要当房主评论',
        component: landlordApplicationComment
      }
          ,{
	path: '/houseRepair',
        name: '房屋报修',
        component: houseRepair
      }
          ,{
	path: '/rentalContract',
        name: '合同信息',
        component: rentalContract
      }
          ,{
	path: '/messageBoard',
        name: '留言板管理',
        component: messageBoard
      }
          ,{
	path: '/config',
        name: '轮播图管理',
        component: config
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
