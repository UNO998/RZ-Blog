import React, {Fragment} from 'react'
import {
  VISIBILITY_FILTER_SHOW_ALL,
  VISIBILITY_FILTER_SHOW_COMPLETED,
  VISIBILITY_SHOW_ACTIVE,
} from '../../../../utils/constant'
import Link from '../Link'

const Footer = ({onClick, visibilityFilter}) => (
  <Fragment>
    <span>Show: </span>
    <Link visibilityFilter={visibilityFilter} filter={VISIBILITY_FILTER_SHOW_ALL} onClick={onClick}>
      All
    </Link>
    <Link visibilityFilter={visibilityFilter} filter={VISIBILITY_SHOW_ACTIVE} onClick={onClick}>
      Active
    </Link>
    <Link visibilityFilter={visibilityFilter} filter={VISIBILITY_FILTER_SHOW_COMPLETED} onClick={onClick}>
      Completed
    </Link>
  </Fragment>
)

export default Footer
