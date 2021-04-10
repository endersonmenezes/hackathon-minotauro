from PIL import Image, ImageDraw
import random


def make_step(k, matrix_graph, cells):
    for i in range(len(matrix_graph)):
        for j in range(len(matrix_graph[i])):
            if matrix_graph[i][j] == k:
                if i > 0 and matrix_graph[i-1][j] == 0 and cells[i-1][j] == 0:
                    matrix_graph[i-1][j] = k + 1
                if j > 0 and matrix_graph[i][j-1] == 0 and cells[i][j-1] == 0:
                    matrix_graph[i][j-1] = k + 1
                if i < len(matrix_graph)-1 and matrix_graph[i+1][j] == 0 and cells[i+1][j] == 0:
                    matrix_graph[i+1][j] = k + 1
                if j < len(matrix_graph[i])-1 and matrix_graph[i][j+1] == 0 and cells[i][j+1] == 0:
                    matrix_graph[i][j+1] = k + 1
    return k, matrix_graph, cells


def print_m(m):
    for i in range(len(m)):
        for j in range(len(m[i])):
            print(str(m[i][j]).ljust(2), end=' ')
        print()


def draw_matrix(matrix_graph, cells, start, end, images, zoom, borders, the_path=[]):
    im = Image.new('RGB', (zoom * len(cells[0]), zoom * len(cells)), (255, 255, 255))
    draw = ImageDraw.Draw(im)
    for i in range(len(cells)):
        for j in range(len(cells[i])):
            color = (255, 255, 255)
            r = 0
            if cells[i][j] == 1:
                color = (0, 0, 0)
            if i == start[0] and j == start[1]:
                color = (0, 255, 0)
                r = borders
            if i == end[0] and j == end[1]:
                color = (0, 255, 0)
                r = borders
            draw.rectangle((j*zoom+r, i*zoom+r, j*zoom+zoom-r-1, i*zoom+zoom-r-1), fill=color)
            if matrix_graph[i][j] > 0:
                r = borders
                draw.ellipse((j * zoom + r, i * zoom + r, j * zoom + zoom - r - 1, i * zoom + zoom - r - 1), fill=(255, 0, 0))
    for u in range(len(the_path)-1):
        y = the_path[u][0]*zoom + int(zoom/2)
        x = the_path[u][1]*zoom + int(zoom/2)
        y1 = the_path[u+1][0]*zoom + int(zoom/2)
        x1 = the_path[u+1][1]*zoom + int(zoom/2)
        draw.line((x, y, x1, y1), fill=(255, 0, 0), width=5)
    draw.rectangle((0, 0, zoom * len(cells[0]), zoom * len(cells)), outline=(0, 255, 0), width=2)
    images.append(im)
    return matrix_graph, cells, start, end, images, zoom, borders


def solution_maze(cells, start, end, zoom, borders):
    images = []
    matrix_graph = []
    for i in range(len(cells)):
        matrix_graph.append([])
        for j in range(len(cells[i])):
            matrix_graph[-1].append(0)
    i, j = start
    matrix_graph[i][j] = 1
    k = 0
    while matrix_graph[end[0]][end[1]] == 0:
        k += 1
        k, matrix_graph, cells = make_step(k, matrix_graph, cells)
        matrix_graph, cells, start, end, images, zoom, borders = draw_matrix(matrix_graph, cells, start, end, images, zoom, borders)
    i, j = end
    k = matrix_graph[i][j]
    the_path = [(i, j)]
    while k > 1:
        if i > 0 and matrix_graph[i - 1][j] == k-1:
            i, j = i-1, j
            the_path.append((i, j))
            k-=1
        elif j > 0 and matrix_graph[i][j - 1] == k-1:
            i, j = i, j-1
            the_path.append((i, j))
            k -= 1
        elif i < len(matrix_graph) - 1 and matrix_graph[i + 1][j] == k-1:
            i, j = i+1, j
            the_path.append((i, j))
            k -= 1
        elif j < len(matrix_graph[i]) - 1 and matrix_graph[i][j + 1] == k-1:
            i, j = i, j+1
            the_path.append((i, j))
            k -= 1
        matrix_graph, cells, start, end, images, zoom, borders = draw_matrix(matrix_graph, cells, start, end, images, zoom, borders, the_path)
    for i in range(10):
        if i % 2 == 0:
            matrix_graph, cells, start, end, images, zoom, borders = draw_matrix(matrix_graph, cells, start, end, images, zoom, borders, the_path)
        else:
            matrix_graph, cells, start, end, images, zoom, borders = draw_matrix(matrix_graph, cells, start, end, images, zoom, borders)
    images[0].save('tempfolder/maze.gif', save_all=True, append_images=images[1:], optimize=False, duration=1, loop=0)
    return {
        'map': cells,
        'solution': the_path,
        'mapImage': 'gifUrl',
    }
