const gulp = require('gulp');

gulp.task('bootstrap', () => 
    gulp.src('node_modules/bootstrap/dist/css/bootstrap.min.css')
    .pipe(gulp.dest('src/main/resources/build/css/'))
);

gulp.task('css', () => 
    gulp.src('src/main/resources/static/css/*.css')
    .pipe(gulp.dest('src/main/resources/build/css/'))
);

gulp.task('default', [ 'bootstrap', 'css' ]);
