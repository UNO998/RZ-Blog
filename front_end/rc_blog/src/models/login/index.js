import {loginAction} from './sagas'
import {LOGIN} from './actions'
import { takeEvery } from 'redux-saga/effects';

const model = {
  * loginAsync() {
    yield takeEvery(LOGIN, loginAction)
  }
}

export default model