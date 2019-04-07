const { src, dest, parallel, watch } = require('gulp');
const minifyCSS = require('gulp-csso');

function bootstrap() {
  return src('node_modules/bootstrap/dist/css/bootstrap.min.css')
    .pipe(dest('src/main/resources/build/css/'))
}

function css() {
  return src('src/main/resources/css/*.css')
    .pipe(minifyCSS())
    .pipe(dest('src/main/resources/build/css/'))
}

function watchFiles() {
  return watch('src/main/resources/css/*.css', css);
}

exports.css = css;
exports.bootstrap = bootstrap;
exports.watch = watchFiles;
exports.default = parallel(bootstrap, css);
