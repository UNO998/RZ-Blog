import React from 'react'
import PropTypes from 'prop-types'

const Link = ({
  children,
  filter,
  onClick,
  visibilityFilter,
}) => (
    <button
       onClick={() => onClick({filter})}
       disabled={visibilityFilter === filter}
       style={{
           marginLeft: '4px',
       }}
    >
      {children}
    </button>
)

Link.propTypes = {
  visibilityFilter: PropTypes.string.isRequired,
  children: PropTypes.node.isRequired,
  onClick: PropTypes.func.isRequired,
  filter: PropTypes.string.isRequired,
}

export default Link
