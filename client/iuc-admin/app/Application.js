/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
Ext.define('IUC.admin.Application', {
    extend: 'Ext.app.Application',

    name: 'IUC.admin',

    quickTips: false,
    platformConfig: {
        desktop: {
            quickTips: true
        }
    },

    stores: [
        // TODO: add global / shared stores here
    ],

    launch: function () {
        // 设置请求头
        Ext.Ajax.on('beforerequest', function (conn, options, eOpts) {
            var tokenInfo = JSON.parse(sessionStorage.getItem('iuc_key')),
                uuid = Ext.data.identifier.Uuid.create().generate();

            options.headers = options.headers || {};
            if(tokenInfo) {
                Ext.apply(options.headers, {
                    'Request-Id': uuid,
                    'Accept': 'application/json',
                    'Content-Type': 'application/json;charset=UTF-8',
                    'Authorization': tokenInfo.token_type + ' ' + tokenInfo.access_token
                });
            }

            if(options.method === 'DELETE' || options.method === 'PUT'){
                if(options.records.length === 1) {
                    Ext.apply(options.headers, {
                        'if-none-match': options.records[0].get('version')
                    });
                }
            }
        });
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});
