/**
 * Created by ltt on 2017/8/24.
 */
Ext.define('IUC.admin.view.user.User', {
    extend: 'Ext.grid.Panel',
    xtype: 'user-list',

    requires: [
        'IUC.admin.view.user.UserController'
    ],

    controller: 'user',
    title: '用户管理',

    requires: [
        'Ext.grid.column.Action',
        'IUC.admin.store.User',
        'IUC.admin.view.user.UserController'
    ],

    store: {
        type: 'users'
    },
    multiSelect: true,
    headerBorders: false,

    viewConfig: {
        enableTextSelection: true
    },

    actions: {
        add: {
            handler: 'onAddClick',
            text: '注册用户'
        },
        edit: {
            handler: 'onEditClick',
            text: '编辑'
        },
        delete: {
            handler: 'onDeleteClick',
            text: '删除'
        }
    },

    columns: [{
        text: '昵称',
        flex: 1,
        dataIndex: 'nickName'
    }, {
        text: '用户名',
        width: 95,
        sortable: true,
        dataIndex: 'userName'
    }],

    tbar: [
        '@add','@edit','@delete'
    ]
});