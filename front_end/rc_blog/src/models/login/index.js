import {loginAction} from './sagas'
import {LOGIN} from './actions'
import { takeLatest } from 'redux-saga/effects';

const model = {
  * loginAsync() {
    yield takeLatest(LOGIN, loginAction)
  }
}

export default model