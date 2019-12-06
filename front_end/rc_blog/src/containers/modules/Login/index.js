import {connect} from 'react-redux'
import {loginUser} from '../../../models/login/actions'
import Login from '../../../routes/login/Login'

const mapStateToProps = ({login}) => ({login})

const mapDispatchToProps = (dispatch) => ({
  loginUser: payload => dispatch(loginUser(payload)),
})

export default connect(
  mapStateToProps,
  mapDispatchToProps,
)(Login)
