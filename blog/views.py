from django.shortcuts import render

def post_list(request):
    return render(request, 'post_list/post_list.html', {})
