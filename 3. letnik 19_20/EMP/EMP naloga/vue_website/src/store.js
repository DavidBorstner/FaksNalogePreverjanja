import Vue from 'vue'
import Vuex from 'vuex'
import router from '@/router.js'
const fb = require('./firebaseConfig.js')

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    appTitle: 'Varuška.si',
    user: null,
    error: null,
    loading: false
  },
  mutations: {
    setUser (state, payload) {
      state.user = payload
    },
    setError (state, payload) {
      state.error = payload
    },
    setLoading (state, payload) {
      state.loading = payload
    }
  },
  actions: {
    userSignUp ({commit}, payload) {
      return new Promise((resolve, reject) => {
        commit('setLoading', true)
        fb.auth.createUserWithEmailAndPassword(payload.email, payload.password)
          .then(firebaseUser => {
            commit('setUser', {email: firebaseUser.user.email})
            commit('setLoading', false)
            router.push('/')
            resolve(data)
          })
          .catch(error => {
            commit('setError', error.message)
            commit('setLoading', false)
            reject(error)
          })
      })

    },
    userSignIn ({commit}, payload) {
      return new Promise((resolve, reject) => {
        commit('setLoading', true)
        fb.auth.signInWithEmailAndPassword(payload.email, payload.password)
          .then(firebaseUser => {
            commit('setUser', {email: firebaseUser.user.email})
            commit('setLoading', false)
            commit('setError', null)
            resolve(firebaseUser)
            router.push('/')
          })
          .catch(error => {
            commit('setError', error.message)
            commit('setLoading', false)
            reject(error)
          })
      })
    },
    autoSignIn ({commit}, payload) {
      commit('setUser', {email: payload.email})
    }
  },
  getters: {

  }
})
