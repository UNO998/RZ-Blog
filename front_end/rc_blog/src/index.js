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
import {HOME_ROUTE_CONFIG} from './routes/home'
import {LOGIN_ROUTE_CONFIG} from './routes/login'
import rootSaga from './models/saga'
import Home from './routes/home/Home'

const sagaMiddleware = createSagaMiddleware();

const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(sagaMiddleware, logger)),
  // other store enhancers if any
);

sagaMiddleware.run(rootSaga);

const routers = [
  TODO_LIST_ROUTE_CONFIG,
];

render(
  <Provider store={store}>
    <BrowserRouter>
      <Home>
        <Switch>
        {routers.map(({ path, component }, key) => (
          <Route exact path={path} component={component} key={key} />
        ))}
        <Route exact path={LOGIN_ROUTE_CONFIG.path} component={LOGIN_ROUTE_CONFIG.component} />
      </Switch>
      </Home>
    </BrowserRouter>
  </Provider>,
  document.getElementById('root')
)
