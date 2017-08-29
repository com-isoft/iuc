/**
 * Created by ltt on 2017/8/24.
 */
Ext.define('IUC.admin.view.user.Add', {
    extend: 'Ext.form.Panel',
    xtype: 'user-add',

    requires: [
        'IUC.admin.view.user.AddController'
    ],

    bodyPadding: 10,
    defaultType: 'textfield',
    controller: 'user-add',

    items: [{
        allowBlank: false,
        fieldLabel: '用户名',
        name: 'userName',
        emptyText: '用户名',
        bind: '{user.userName}'
    }, {
        allowBlank: false,
        fieldLabel: '昵称',
        name: 'nickName',
        emptyText: '昵称',
        bind: '{user.nickName}'
    }, {
        allowBlank: false,
        fieldLabel: '密码',
        name: 'password',
        emptyText: '密码',
        inputType: 'password',
        bind: '{user.password}'
    }, {
        allowBlank: false,
        fieldLabel: '电话',
        name: 'phone',
        emptyText: '电话',
        bind: '{user.phone}'
    }, {
        allowBlank: false,
        fieldLabel: '邮箱',
        name: 'email',
        emptyText: '邮箱',
        bind: '{user.email}'
    }],

    buttons: [{
        text: '注册',
        listeners: {
            click: 'onRegisterClick'
        }
    }, {
        text: '取消',
        listeners: {
            click: 'onCancelClick'
        }
    }],

    defaults: {
        anchor: '100%',
        labelWidth: 120
    }
});