class GoogleDriveView {

    constructor() {
        this.album = $('#album_id');

        $('#album_btn').click(
            () => this.handleAlbum()
        );
    }


    handleAlbum() {
        const album_id = $(this.album).val();
        if (album_id) {
            $(this).trigger('album', album_id);
        }
    }

    showAlbumError() {
        let albumError = $('#album_error');
        albumError.addClass("alert alert-danger");
        albumError.text(`Album ${$(this.album).val()} does not exist`);
        $(this.album).val("");
    }

}


export default GoogleDriveView;
