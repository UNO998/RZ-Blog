const ADD_TODO = 'ADD_TODO'
const SET_VISIBILITY_FILTER = 'SET_VISIBILITY_FILTER'
const TOGGLE_TODO = 'TOGGLE_TODO'

let nextTodoId = 0
export const addTodo = payload => ({
  type: ADD_TODO,
  payload: {
    id: nextTodoId++,
    ...payload,
  }
})

export const setVisibilityFilter = payload => ({
  type: SET_VISIBILITY_FILTER,
  payload,
})

export const toggleTodo = payload => ({
  type: TOGGLE_TODO,
  payload,
})

