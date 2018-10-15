import Vue from 'vue'
import Router from 'vue-router'
import PokePage from '@/components/PokePage'
import ChatPage from '@/components/ChatPage'
import PortfolioPage from '@/components/PortfolioPage'
import NotFoundComponent from '@/components/NotFoundComponent'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'PortfolioPage',
      component: PortfolioPage
    },
    {
      path: '/poke',
      name: 'PokePage',
      component: PokePage
    },
    {
      path: '/chat',
      name: 'ChatPage',
      component: ChatPage
    },
    {
      path: '*',
      component: NotFoundComponent
    },
  ]
})
