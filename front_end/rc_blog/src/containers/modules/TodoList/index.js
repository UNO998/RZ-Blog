import {
  addTodo,
  toggleTodo,
  setVisibilityFilter
} from '../../../models/todo/actions'
import {
  VISIBILITY_FILTER_SHOW_ALL,
  VISIBILITY_FILTER_SHOW_COMPLETED,
  VISIBILITY_SHOW_ACTIVE,
} from '../../../utils/constant'
import {connect} from 'react-redux'
import TodoList from '../../../routes/todo/TodoList'

const getVisibleTodos = (todos, filter) => {
  switch (filter) {
    case VISIBILITY_FILTER_SHOW_ALL:
      return todos
    case VISIBILITY_FILTER_SHOW_COMPLETED:
      return todos.filter(t => t.completed)
    case VISIBILITY_SHOW_ACTIVE:
      return todos.filter(t => !t.completed)
    default:
      throw new Error('Unknown filter: ' + filter)
  }
}

const mapStateToProps = ({todo}) => ({
  visibilityFilter: todo.visibilityFilter,
  todos: getVisibleTodos(todo.todos, todo.visibilityFilter),
})

const mapDispatchToProps = (dispatch) => ({
  toggleTodo: payload => dispatch(toggleTodo(payload)),
  addTodo: payload => dispatch(addTodo(payload)),
  onClick: payload => dispatch(setVisibilityFilter(payload)),
})

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TodoList)
