import Vue from 'vue'
import Router from 'vue-router'
import PokePage from '@/components/PokePage'
import PortfolioPage from '@/components/PortfolioPage'
import LetterPage from '@/components/LetterPage'
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
      path: '/letter',
      name: 'Letter',
      component: LetterPage
    },
    {
      path: '*',
      component: NotFoundComponent
    },
  ]
})
