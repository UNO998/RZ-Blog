import React from 'react'
import Home from './Home'
export const HOME_ROUTE = '/home'

export const HOME_ROUTE_CONFIG={
  path: HOME_ROUTE,
  component: internalProps => <Home {...internalProps} />,
}