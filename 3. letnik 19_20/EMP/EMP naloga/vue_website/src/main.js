import '@babel/polyfill'
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
const fb = require('./firebaseConfig.js')

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)

import { library } from '@fortawesome/fontawesome-svg-core'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(fas)

Vue.component('fa-icon', FontAwesomeIcon)
import MatchPlayerTable from '@/components/MatchPlayerTable.vue'
Vue.component('match-player-table', MatchPlayerTable)

Vue.config.productionTip = false

let app
fb.auth.onAuthStateChanged(user => {
  if (!app) {
    app = new Vue({
      el: '#app',
      router,
      store,
      render: h => h(App),
      created() {
        if (user) {
          store.dispatch('autoSignIn', user)
        }
      }
    })
  }
})
