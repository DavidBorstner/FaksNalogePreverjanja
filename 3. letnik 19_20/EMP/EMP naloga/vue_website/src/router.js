import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from './views/Login.vue'
import Secret from './views/Secret.vue'
import firebase from 'firebase'
import Signup from './views/Signup.vue'
import About from './views/About.vue'
import DataInput from './views/DataInput.vue'
import Players from './views/Players.vue'
import Player from './views/Player.vue'
import Team from './views/Team.vue'
import MatchInput from './views/MatchInput.vue'
import Match from './views/Match.vue'
import LiveFeed from './views/LiveFeed.vue'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about/',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: About
    },
    {
      path: '/login/',
      name: 'login',
      component: Login,
      meta: {
        noAuth: true
      }
    },
    {
      path: '/signup/',
      name: 'signup',
      component: Signup,
      meta: {
        noAuth: true
      }
    },
    {
      path: '/secret/',
      name: 'secret',
      component: Secret,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/datainput/',
      name: 'datainput',
      component: DataInput,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/igralci/',
      name: 'igralci',
      component: Players
    },
    {
      path: '/igralci/:id/',
      name: 'igralec',
      component: Player
    },
    {
      path: '/ekipe/:id/',
      name: 'ekipa',
      component: Team
    },
    {
      path: '/zapisniki/',
      name: 'zapisniki',
      component: MatchInput
    },
    {
      path: '/zapisniki/:id/',
      name: 'zapisnik',
      component: Match
    },
    {
      path: '/zapisniki/:id/live/',
      name: 'zapisnik_live',
      component: LiveFeed
    }
  ]
})

router.beforeEach((to, from, next) => {
  const currentUser = firebase.auth().currentUser
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth)

  if (requiresAuth && !currentUser) {
    next('login')
  } else {
    next()
  }
})

export default router
