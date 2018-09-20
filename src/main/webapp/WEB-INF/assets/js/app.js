import GoogleDriveView from "./view/google-drive-view.js";
import GoogleDriveController from "./controller/google-drive-controller.js";


/*DZ.init({
    appId  : '300404'
    ,channelUrl : 'http://localhost:8085/assets/channel.html'
});*/
const googleDriveView = new GoogleDriveView();
new GoogleDriveController(googleDriveView);