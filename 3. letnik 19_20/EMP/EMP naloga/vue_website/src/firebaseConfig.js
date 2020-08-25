import firebase from 'firebase'
import 'firebase/firestore'
import Vue from 'vue'

import { firestorePlugin } from 'vuefire'
Vue.use(firestorePlugin)

// firebase init goes here
let config = {
  apiKey: "AIzaSyCPD2jS2RJ27c5bPZejHvZY6LnbgVBQgCg",
  authDomain: "varuska-da1f3.firebaseapp.com",
  databaseURL: "https://varuska-da1f3.firebaseio.com",
  projectId: "varuska-da1f3",
  storageBucket: "varuska-da1f3.appspot.com",
  messagingSenderId: "457715514543"
};
firebase.initializeApp(config);

// firebase utils
const db = firebase.firestore()
const auth = firebase.auth()
const currentUser = auth.currentUser

// firebase collections
// const usersCollection = db.collection('users')
// const postsCollection = db.collection('posts')
// const commentsCollection = db.collection('comments')
// const likesCollection = db.collection('likes')

export {
  db,
  auth,
  currentUser
}
