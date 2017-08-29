/**
 * Created by ltt on 2017/8/24.
 */
Ext.define('IUC.admin.model.User', {
    extend: 'Ext.data.Model',

    fields: [{
        name: 'id',
        type: 'string',
        persist: false
    },{
        name: 'nickName',
        type: 'string'
    }, {
        name: 'userName',
        type: 'string'
    }, {
        name: 'password',
        type: 'string'
    }, {
        name: 'phone',
        type: 'string'
    }, {
        name: 'email',
        type: 'string'
    }],

    proxy: {
        type: 'rest',
        url: 'http://localhost:8001/users',
        writer: {
            writeAllFields: true,
            dateFormat: 'C',
            allDataOptions: {
                associated: true
            }
        }
    }
});