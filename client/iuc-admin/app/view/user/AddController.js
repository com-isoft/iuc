/**
 * Created by ltt on 2017/8/24.
 */
Ext.define('IUC.admin.view.user.AddController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.user-add',

    onRegisterClick: function () {
        var user= this.getViewModel().getData().user;

        user.save({
            callback: function(record, operation, success) {
                alert(record);
            }
        });
    },

    onCancelClick: function () {
        this.getView().up('window').close();
    }
});