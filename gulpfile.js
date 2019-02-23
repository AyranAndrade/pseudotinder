const { src, dest, parallel } = require('gulp');
const minifyCSS = require('gulp-csso');

function bootstrap() {
  return src('node_modules/bootstrap/dist/css/bootstrap.min.css')
    .pipe(dest('src/main/resources/build/css/'))
}

function css() {
  return src('src/main/resources/static/css/*.css')
    .pipe(minifyCSS())
    .pipe(dest('src/main/resources/build/css/'))
}

exports.css = css;
exports.bootstrap = bootstrap;
exports.default = parallel(bootstrap, css);