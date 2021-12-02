if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'FrontEnd'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'FrontEnd'.");
}var FrontEnd = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function limpar() {
    var elem = document.getElementById('p1');
    if (elem != null) {
      elem.innerHTML = '';
    }}
  function botaoClicado(nome) {
    println('O usuario clicou o bot\xE3o ' + nome);
    var elem = document.getElementById('p1');
    if (elem != null) {
      elem.innerHTML = elem.innerHTML + ('\n' + '            <br> <font color=' + '"' + nome + '"' + '>Este texto foi inserido pelo programa Kotlin ' + '\n' + '            ao pressionar o botao ' + nome + '<\/font>' + '\n' + '            <button onclick=' + '"' + "FrontEnd.botaoClicado('yellow')" + '"' + '>Nao aperte esse botao<\/button>' + '\n' + '            ');
    }}
  function main() {
    println('ola do navegador');
    for (var c = 1; c <= 100; c++)
      println('Linha impressa em kotlin numero ' + c);
  }
  _.botaoLimpar = limpar;
  _.botaoClicado = botaoClicado;
  _.main = main;
  main();
  Kotlin.defineModule('FrontEnd', _);
  return _;
}(typeof FrontEnd === 'undefined' ? {} : FrontEnd, kotlin);
