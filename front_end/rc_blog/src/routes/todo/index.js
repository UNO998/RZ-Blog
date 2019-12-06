import React from 'react'
import TodoList from '../../containers/modules/TodoList'
export const TODO_LIST_ROUTE = '/todo'

export const TODO_LIST_ROUTE_CONFIG={
  path: TODO_LIST_ROUTE,
  component: internalProps => <TodoList {...internalProps} />,
}

export {default as TodoList} from './TodoList'