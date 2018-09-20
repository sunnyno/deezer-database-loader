class GoogleDriveController {
    constructor(view) {
        this.view = view;
        $(this.view).on('album', (event, album_id) => this.loadAlbum(album_id));
    }


    loadAlbum(album_id) {
        $.ajax({
            url: `https://cors-anywhere.herokuapp.com/https://api.deezer.com/album/${album_id}`,
            method: 'GET',
            success: (data) => this.handleAlbumData(data)
        });
    }

    handleAlbumData(data) {
        console.log(data);
        if (data.error) {
            this.view.showAlbumError();
        } else {
            let genres = data.genres.data.map(a => a.name);
            console.log(genres);
            $.post('/artist', {name: data.artist.name, picture: data.artist.picture_medium},
                $.post('/album', {artist: data.artist.name, name: data.title, picture: data.cover_medium},
                    this.postSongList(data.tracks.data, data.cover_medium, data.title, genres)));
        }
    }


    postSong(track, cover, album, genres) {
        $.post('/song', {
                data: track.preview, artist: track.artist.name, title: track.title,
                picture: cover, album: album, genres:genres
            },
            console.log(`${track.title} of ${track.artist.name} loaded`));
    }

    postSongList(tracks, cover, album, genres) {
        for (let t in tracks) {
            let track = tracks[t];
            this.postSong(track, cover, album, genres);
        }
    }

}

export default GoogleDriveController;