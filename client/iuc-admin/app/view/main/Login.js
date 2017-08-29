/**
 * Created by ltt on 2017/8/23.
 */
Ext.define('IUC.admin.view.main.Login', {
    extend: 'Ext.form.Panel',
    xtype: 'form-login',

    title: 'Login',
    bodyPadding: 10,

    defaultType: 'textfield',

    items: [{
        allowBlank: false,
        fieldLabel: 'User ID',
        name: 'user',
        emptyText: 'user id'
    }, {
        allowBlank: false,
        fieldLabel: 'Password',
        name: 'pass',
        emptyText: 'password',
        inputType: 'password'
    }],

    buttons: [{
        text: 'Login',
        listeners:{
            click: function(el){
                el.up('panel').mask("正在登录...");
                Ext.Ajax.request({
                    url: 'http://localhost:8001/token',
                    method: 'POST',
                    headers:{
                        'Content-Type':'application/json'
                    },
                    jsonData: {
                        username: 'admin',
                        password: 'admin'
                    },
                    callback: function(options,success,response){
                        el.up('panel').unmask();
                        sessionStorage.setItem("iuc_key",response.responseText)
                    }
                })
            }
        }
    }],

    defaults: {
        anchor: '100%',
        labelWidth: 120
    }
});