import React from 'react'
import { Layout, Menu, Breadcrumb, Icon } from 'antd';
import styled from 'styled-components'
import {Header} from '../../../components'
import { withRouter, Link } from 'react-router-dom';
import config from '../../../utils/config'

const StaledLayout = styled(Layout)`
  height: 100vh;
`
const { SubMenu } = Menu;
const { Content, Sider } = Layout;

const breadcrumbNameMap = {
  '/user': '用户管理',
  '/articleList': '文章列表',
  '/postArticle': '发表文章',
  '/cateMana': '栏目管理',
  '/charts': '数据管理',
};

const Home = ({
  location,
  history,
  children,
}) => {
  const pathSnippets = location.pathname.split('/').filter(i => i);
  const extraBreadcrumbItems = pathSnippets.map((_, index) => {
    const url = `/${pathSnippets.slice(0, index + 1).join('/')}`;
    return (
      <Breadcrumb.Item key={url}>
        <Link to={url}>{breadcrumbNameMap[url]}</Link>
      </Breadcrumb.Item>
    );
  });

  const breadcrumbItems = [
    <Breadcrumb.Item key="home">
      <Link to="/home">首页</Link>
    </Breadcrumb.Item>,
  ].concat(extraBreadcrumbItems);

  const {openPages} = config
  let {pathname} = location
  pathname = pathname.startsWith('/') ? pathname : `/${pathname}`
  if (openPages.includes(pathname)) 
    return <div>{children}</div>
  return (
    <StaledLayout>
      <Header />
      <Layout>
        <Sider width={200} style={{ background: '#fff' }}>
          <Menu
            mode="inline"
            defaultSelectedKeys={['1']}
            defaultOpenKeys={['sub1']}
            theme="dark"
            style={{ height: '100%', borderRight: 0 }}
            onClick={({key}) => {
              history.push(key)
            }}
          >
            <SubMenu
              key="sub1"
              title={
                <span>
                  <Icon type="book" />
                  文章管理
                </span>
              } >
              <Menu.Item key="articleList">文章列表</Menu.Item>
              <Menu.Item key="postArticle">发表文章</Menu.Item>
            </SubMenu>
              <Menu.Item key="user">
                <Icon type="user" />
                用户管理
              </Menu.Item>
              <Menu.Item key="cateMana">
                <Icon type="menu" />
                栏目管理
              </Menu.Item>
              <Menu.Item key="charts">
                <Icon type="bar-chart" />                
                数据管理
              </Menu.Item>
          </Menu>
        </Sider>
        <Layout style={{ padding: '10px 24px 24px', 'background-color': 'white' }}>
          <Breadcrumb separator=">">{breadcrumbItems}</Breadcrumb>
          <Content
            style={{
              background: '#fff',
              padding: 24,
              margin: 0,
              minHeight: 280,
            }}
          >
            {children}
        </Content>
      </Layout>
    </Layout>
  </StaledLayout>
  )
}

export default withRouter(Home)