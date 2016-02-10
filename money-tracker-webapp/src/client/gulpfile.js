var gulp = require('gulp');
var $ = require('gulp-load-plugins')({lazy: true});
var wiredep = require('wiredep').stream;

var ROOT_DIR = './public';

gulp.task('html', function(){

    log('Processing the main html file..');
    gulp.src(ROOT_DIR + '/index.html')
        .pipe($.plumber())
        .pipe(wiredep({}))//.pipe($.useref({searchPath: './'}))
        .pipe(gulp.dest(ROOT_DIR));
});

gulp.task('default', ['html']);

///////////////////// HELPER FUNCTIONS //////////////////////////

function log(msg) {
    var colored = $.util.colors.blue(msg);
    console.log(colored);
}

