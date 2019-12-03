import 'antd/dist/antd.css';
import React from 'react'
import { render } from 'react-dom'
import createSagaMiddleware from 'redux-saga';
import { createStore, applyMiddleware } from 'redux'
import { Provider } from 'react-redux'
import { logger } from 'redux-logger';
import rootReducer from './models'
import { composeWithDevTools } from "redux-devtools-extension";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import {TODO_LIST_ROUTE_CONFIG} from './routes/todo'
import {LOGIN_ROUTE_CONFIG} from './routes/login'
import rootSaga from './models/saga'

const sagaMiddleware = createSagaMiddleware();

const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(sagaMiddleware, logger)),
  // other store enhancers if any
);

sagaMiddleware.run(rootSaga);

const routers = [
  LOGIN_ROUTE_CONFIG,
  TODO_LIST_ROUTE_CONFIG,
];

render(
  <Provider store={store}>
    <BrowserRouter>
      <Switch>
        {routers.map(({ path, component }, key) => (
          <Route exact path={path} component={component} key={key} />
        ))}
      </Switch>
    </BrowserRouter>
  </Provider>,
  document.getElementById('root')
)
