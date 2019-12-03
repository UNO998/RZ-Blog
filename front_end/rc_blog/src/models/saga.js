import {all } from 'redux-saga/effects'
import model from './login'
const {loginAsync} = model
export default function* rootSaga() {
  yield all([
    loginAsync()
  ])
}