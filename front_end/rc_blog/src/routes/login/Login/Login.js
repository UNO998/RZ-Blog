import {
  Button,
  Checkbox,
  Col,
  Form,
  Input,
  Row,
} from 'antd';
import React from 'react';
import styled from 'styled-components'

const LoginContainer = styled.div`
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
`
const LoginTitle = styled.h3`
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
`

const LoginButton = styled(Button)`
  width: 100%;
  margin-top: 10px;
`


const Login = ({
  form,
  loginUser,
}) => {
  const {getFieldDecorator, validateFieldsAndScroll} = form

  const handleLogin = () => {
    validateFieldsAndScroll((errors, values) => {
      if (errors) return
      loginUser(values)
    })
  }

  return (
    <LoginContainer>
      <LoginTitle>系统登录</LoginTitle>
      <Row justify='center' type='flex'>
        <Col lg={12} sm={14} xl={18} xs={24} xxl={14}>
          <Form.Item>
            {getFieldDecorator('username', {
              initialValue: '',
              rules: [{
                required: true,
                message: 'plz input username'
              }]
            })(<Input onPressEnter={handleLogin} placeholder='username' />)}
          </Form.Item>
          <Form.Item>
            {getFieldDecorator('password', {
              initialValue: '',
              rules: [{
                required: true,
                message: 'plz input password'
              }]
            })(<Input
                onPressEnter={handleLogin}
                placeholder='password'
                type='password' />)}
          </Form.Item>
          <Form.Item>
            {getFieldDecorator('remember', {
              valuePropName: 'checked',
              initialValue: true,
            })(<Checkbox>Remember me</Checkbox>)}
            <LoginButton type="primary" htmlType="submit" onClick={handleLogin}>
              Log in
            </LoginButton>
        </Form.Item>
        </Col>
      </Row>
    </LoginContainer>
  )
}

export default Form.create()(Login)