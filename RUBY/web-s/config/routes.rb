Rails.application.routes.draw do
  get 'bubble/:str', to: 'application#bubble'
  get 'quick/:str', to: 'application#quick'
  get 'merge/:str', to: 'application#merge'


  # reciben la veriable str como data en el post
  post 'bubble', to: 'application#bubble'
  post 'quick', to: 'application#quick'
  post 'merge', to: 'application#merge'
end
