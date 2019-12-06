import {VISIBILITY_FILTER_SHOW_ALL} from '../../utils/constant'
const initialState = {
  todos: [],
  visibilityFilter: VISIBILITY_FILTER_SHOW_ALL,
}

const todo = (state = initialState, action) => {
  const {type, payload} = action
  const copiedState = Object.assign({}, state);
  const {todos} = copiedState
  switch (type) {
    case 'ADD_TODO':
      const {id, text} = payload
      copiedState.todos = todos.concat({
        id,
        text,
        completed: false
      })
      return copiedState
    case 'TOGGLE_TODO':
        copiedState.todos = todos.map(todo =>
        (todo.id === payload.id)
          ? {...todo, completed: !todo.completed}
          : todo
      )
      return copiedState

    case 'SET_VISIBILITY_FILTER':
        return {
          ...state,
          visibilityFilter: payload && payload.filter,
        }
    default:
      return state
  }
}

export default todo
