/**
 * Created by ltt on 2017/8/28.
 */
Ext.define('IUC.admin.view.user.EditController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.user-edit',

    doLoadData: function () {
        var model = this.getViewModel().getData().user;

        model.load();
    },

    onOkClick: function () {
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