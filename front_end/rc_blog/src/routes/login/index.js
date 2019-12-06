import React from 'react'
import Login from '../../containers/modules/Login'
export const LOGIN_ROUTE = '/'

export const LOGIN_ROUTE_CONFIG={
  path: LOGIN_ROUTE,
  component: internalProps => <Login {...internalProps} />,
}