def solution(genres, plays):
    answer = []
    genres_total = {}
    genres_songs = {}
    for i in range(len(genres)):
        if genres[i] in genres_total:
            genres_total[genres[i]] += plays[i]
            genres_songs[genres[i]].append([i, plays[i]])
        else:
            genres_total[genres[i]] = plays[i]
            genres_songs[genres[i]] = [[i, plays[i]]]
    
    sorted_genres_total = sorted(genres_total.items(), key = lambda x: -x[1])
    for g, n in sorted_genres_total:
        sorted_genres_song = sorted(genres_songs[g], key = lambda x: (-x[1], x[0]))
        num = 0
        for s in sorted_genres_song:
            if num == 2:
                break
            answer.append(s[0])
            num += 1
            
    return answer