import {
  AddTodo,
  Footer,
  ListTodo,
} from '../components'
import React, {Fragment}from 'react'

const TodoList = ({
  addTodo,
  onClick,
  todos,
  toggleTodo,
  visibilityFilter,
}) => (
    <Fragment>
      <AddTodo addTodo={addTodo} />
      <ListTodo todos={todos} toggleTodo={toggleTodo} />
      <Footer onClick={onClick} visibilityFilter={visibilityFilter} />
  </Fragment>
)

export default TodoList