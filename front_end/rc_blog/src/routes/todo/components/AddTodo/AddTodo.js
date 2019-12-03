import React, {Fragment} from 'react'

const AddTodo = ({ addTodo }) => {
  let input

  return (
    <Fragment>
      <form onSubmit={e => {
        e.preventDefault()
        if (!input.value.trim()) {
          return
        }
        addTodo({text: input.value})
        input.value = ''
      }}>
        <input ref={node => input = node} />
        <button type="submit">
          Add Todo
        </button>
      </form>
    </Fragment>
  )
}

export default AddTodo
