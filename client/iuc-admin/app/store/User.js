/**
 * Created by ltt on 2017/8/24.
 */
Ext.define('IUC.admin.store.User', {
    extend: 'Ext.data.Store',
    alias: 'store.users',

    requires: [
        'IUC.admin.model.User'
    ],

    model: IUC.admin.model.User,

    remoteFilter: true,
    remoteSort: true,

    proxy: {
        type: 'rest',
        url: 'http://localhost:8001/users',
        reader: {
            type: 'json',
            rootProperty: 'content'
        },
        writer: {
            writeAllFields: true,
            dateFormat: 'C',
            allDataOptions: {
                associated: true
            }
        }
    }
});