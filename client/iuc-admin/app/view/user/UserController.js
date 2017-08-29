/**
 * Created by ltt on 2017/8/24.
 */
Ext.define('IUC.admin.view.user.UserController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.user',

    requires: [
        'IUC.admin.model.User',
        'IUC.admin.view.user.Add',
        'IUC.admin.view.user.Edit'
    ],

    onAddClick: function () {
        Ext.create({
            xtype: 'window',
            items: [{
                xtype: 'user-add',
                viewModel: {
                    data: {
                        user: new IUC.admin.model.User()
                    }
                }
            }],
            modal: true,
            width: 600,
            height: 400,
            layout: 'fit'
        }).show();
    },
    onEditClick: function () {
        var data = this.getView().getSelection()[0];

        Ext.create({
            xtype: 'window',
            items: [{
                xtype: 'user-edit',
                viewModel: {
                    data: {
                        user: new IUC.admin.model.User({id: data.getId()})
                    }
                }
            }],
            modal: true,
            width: 600,
            height: 400,
            layout: 'fit'
        }).show();
    },
    onDeleteClick: function () {
        var data = this.getView().getSelection();

        Ext.each(data, function (item) {
            item.erase();
        });
    }
});