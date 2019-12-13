import {
  Col,
  Dropdown,
  Icon,
  Layout,
  Menu,
  message,
  Row,
} from 'antd'
import React from 'react'
import styled from 'styled-components'

const StyledLayoutHeader = styled(Layout.Header)`
  &.ant-layout-header {
    padding: 0 1rem;
    background-color: #20a0ff;
  }
`

const HomeTitle = styled(Col)`
  color: #fff;
  font-size: 22px;
  display: inline;
`

const onClick = ({ key }) => {
  message.info(`Click on item ${key}`);
};


const Header = () => {
  return (
    <StyledLayoutHeader>
      <Row align='middle' justify='space-between' type='flex'>
        <LeftColumnContent />
        <RightColumnContent />
      </Row>
    </StyledLayoutHeader>
  )
}


const LeftColumnContent = () => {
  return (
    <HomeTitle>
      V部落博客管理平台
    </HomeTitle>
  )
}

const RightColumnContent = () => {
  return (
    <Col>
      <Dropdown
        overlay={
          <Menu onClick={onClick}>
          <Menu.Item key="1">系统信息</Menu.Item>
          <Menu.Item key="2">我的文章</Menu.Item>
          <Menu.Item key="3">个人主页</Menu.Item>
          <Menu.Divider />
          <Menu.Item key="4">
            退出登陆
          </Menu.Item>
        </Menu>
        }
        trigger={['click', 'hover']}>
        <Col style={{'cursor': 'pointer', 'color': 'white'}}>游客 <Icon type="down" /></Col>
      </Dropdown>
    </Col>
  )
}

export default Header