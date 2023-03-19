#!/usr/bin/env bash

mvn=./mvnw

# Import .env file as environment variables
[ -f .env ] && export "$(grep -v '^#' .env | xargs -d '\n')"

function help {
  echo "$0 <task> <args>"
  echo "Tasks:"
  compgen -A function | cat -n
}

function load_git_env {
  echo export GIT_COMMITTER_NAME="$(git config user.name)"
  echo export GIT_COMMITTER_EMAIL="$(git config user.email)"
  echo export GIT_AUTHOR_NAME="$(git config user.name)"
  echo export GIT_AUTHOR_EMAIL="$(git config user.email)"
}

function check {
  $mvn spotless:check
}

function format {
  $mvn spotless:apply
}

function verify {
  $mvn clean verify
}

TIMEFORMAT="Task '${1:-help}' completed in %3lR"
time "${@:-help}"

# Unset all environment variables from .env file loaded at beginning
[ -f .env ] && unset "$(grep -v '^#' .env | sed -E 's/(.*)=.*/\1/' | xargs)"
