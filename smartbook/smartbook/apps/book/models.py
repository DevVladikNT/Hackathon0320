from django.db import models

class Book(models.Model):
	book_title = models.CharField('Название книги', max_length = 100)
	#book_image = models.ImageField(upload_to = '', height_field = , width_field = )
	book_description = models.TextField('Описание книги')
	book_date_publish = models.DateTimeField('Дата добавления')
	book_rating = models.CharField('Оценка книги', max_length = 4)

	def __str__(self):
		return self.book_title

class Comment(models.Model):
	book = models.ForeignKey(Book, on_delete = models.CASCADE)
	author_name = models.CharField('Имя автора', max_length = 50)
	comment_text = models.CharField('Текст комментария', max_length = 300)

	def __str__(self):
		return self.author_name